import React from 'react'
import { useTable } from 'react-table'
import { collection, doc, deleteDoc, onSnapshot } from "firebase/firestore";
import { db } from 'config/firebase'
import Form from 'component/Form'

function App() {
	const [inventory, setInventory] = React.useState([])

	React.useEffect(() => {
		const unsub = onSnapshot(collection(db, "inventory"), (data) => {
			setInventory(data.docs.map(doc => ({ ...doc.data(), id: doc.id })));
		});
		return unsub
	}, [])

	const columns = React.useMemo(
		() => [...Object.keys(inventory[0] || {}).map(x => {
			let Header = x.slice(0, 1).toUpperCase() + x.slice(1)
			if (x === 'id') Header = 'Kode Barang'
			if (x === 'name') Header = 'Nama'
			if (x === 'quantity') Header = 'Jumlah'
			if (x === 'unit') Header = 'Satuan'
			if (x === 'price') Header = 'Harga Pokok'

			return {
				Header,
				accessor: x, // accessor is the "key" in the data
			}
		}), {
			Header: 'Aksi', Cell: ({ row }) => (
				<div>
					<button onClick={() => handleDelete(row.original)}>Hapus</button>
				</div>
			)
		}],
		[inventory]
	)

	const handleDelete = async ({ id }) => {
		deleteDoc(doc(db, "inventory", id));
	}

	const {
		getTableProps,
		getTableBodyProps,
		headerGroups,
		rows,
		prepareRow,
	} = useTable({
		columns,
		data: inventory
	})

	return (
		<div className="container mt3">
			<Form />
			<table {...getTableProps()} style={{ border: 'solid 1px blue' }}>
				<thead>
					{headerGroups.map(headerGroup => (
						<tr {...headerGroup.getHeaderGroupProps()}>
							{headerGroup.headers.map(column => (
								<th
									{...column.getHeaderProps()}
									style={{
										borderBottom: 'solid 3px red',
										background: 'aliceblue',
										color: 'black',
										fontWeight: 'bold',
										padding: 12
									}}
								>
									{column.render('Header')}
								</th>
							))}
						</tr>
					))}
				</thead>
				<tbody {...getTableBodyProps()}>
					{rows.map(row => {
						prepareRow(row)
						return (
							<tr {...row.getRowProps()}>
								{row.cells.map(cell => {
									return (
										<td
											{...cell.getCellProps()}
											style={{
												padding: '10px',
												border: 'solid 1px gray',
												background: 'papayawhip',
											}}
										>
											{cell.render('Cell')}
										</td>
									)
								})}
							</tr>
						)
					})}
				</tbody>
			</table>
		</div>
	)
}

export default App