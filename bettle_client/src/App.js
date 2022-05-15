import './App.css';
import { Route, Routes } from 'react-router-dom';
import React, {useState} from "react";
import UserComponent from './components/UserComponent';
import HomeComponent from './components/HomeComponent';
import NavBar from './components/NavBar';
import LoginComponent from './components/LoginComponent';

function App() {
  const [name, setNameInside] = useState({username: (localStorage.getItem('username') !== null ? localStorage.getItem('username') : "") });
  
    const setName = (username) => {
      setNameInside({username});
      if(username === "")
        localStorage.removeItem('username');
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
      </Routes>
    </div>
  );
}

export default App;
