import { initializeApp } from 'firebase/app';
import { getFirestore } from 'firebase/firestore'

const app = initializeApp({
  apiKey: "AIzaSyBEAnwtlyZemTnARxITKqpec1dkGQgNYw4",
  authDomain: "binus-soa-tk1.firebaseapp.com",
  projectId: "binus-soa-tk1",
  storageBucket: "binus-soa-tk1.appspot.com",
  messagingSenderId: "26485368292",
  appId: "1:26485368292:web:05db24e2f8d3de6ede93f1"
});

export const db = getFirestore(app);
