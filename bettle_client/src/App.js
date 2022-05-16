import './App.css';
import { Route, Routes } from 'react-router-dom';
import React, {useState} from "react";
import UserComponent from './components/UserComponent';
import HomeComponent from './components/HomeComponent';
import NavBar from './components/NavBar';
import LoginComponent from './components/LoginComponent';
import RegisterComponent from './components/RegisterComponent';

function App() {
  const [name, setNameInside] = useState({username: (localStorage.getItem('username') !== null ? localStorage.getItem('username') : "") });
  
    const setName = (username) => {
      setNameInside({username});
      if(username === ""){
        localStorage.removeItem('username');
        localStorage.removeItem('token');
      }
      else
        localStorage.setItem('username', name);
    }

    const getName = () => {
      return name.username;
    }

  return (
    <div className="App">
      <NavBar setName={setName} getName={getName}/>
      <Routes>
        <Route path='/home' element={<HomeComponent/>} />
        <Route path='/users' element={<UserComponent/>} />
        <Route path='/' element={<LoginComponent setName={setName} getName={getName} />} />
        <Route path='/register' element={<RegisterComponent/>} />
      </Routes>
    </div>
  );
}

export default App;
