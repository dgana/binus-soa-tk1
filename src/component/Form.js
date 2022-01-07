import { useState } from 'react'
import { collection, addDoc } from "firebase/firestore";
import { db } from 'config/firebase'

const inputStyle = {
	marginRight: 12
}

const divStyle = {
	display: 'grid',
	gridTemplateColumns: '1fr 16px 1fr',
	marginBottom: 4
}

const Form = () => {
	const [form, setForm] = useState({
		name: '',
		quantity: 0,
		price: 0,
		unit: 'pcs'
	})

	const onChange = (e) => {
		setForm(state => ({ ...state, [e.target.name]: e.target.value }))
	}

	const onSubmit = (e) => {
		e.preventDefault()
		addDoc(collection(db, "inventory"), form)
	}

	return (
		<form onSubmit={onSubmit} style={{ marginBottom: 24, width: '20rem' }}>
			<div style={divStyle}>
				<label>Nama Barang</label>
				<div>:</div>
				<input type="text" style={inputStyle} name="name" value={form.name} placeholder='Input Nama Barang' onChange={onChange} />
			</div>
			<div style={divStyle}>
				<label>Jumlah Barang</label>
				<div>:</div>
				<input type="number" style={inputStyle} name="quantity" value={form.quantity || ''} placeholder='Input Jumlah Barang' onChange={onChange} />
			</div>
			<div style={divStyle}>
				<label>Harga Barang</label>
				<div>:</div>
				<input type="number" style={inputStyle} name="price" value={form.price || ''} placeholder='Input Harga Barang' onChange={onChange} />
			</div>
			<div style={divStyle}>
				<label>Unit Barang</label>
				<div>:</div>
				<input type="text" style={inputStyle} name="unit" value={form.unit} placeholder='Input Unit Barang' onChange={onChange} />
			</div>
			<div>
				<input type="submit" value="Tambah" />
			</div>
		</form>
	)
}

export default Form
