import './App.css';
import { Route, Routes } from 'react-router-dom';
import React, {useState} from "react";
import UserComponent from './components/UserComponent';
import HomeComponent from './components/HomeComponent';
import NavBar from './components/NavBar';
import LoginComponent from './components/LoginComponent';
import RegisterComponent from './components/RegisterComponent';
import BetslipPage from './components/BetslipPage';
import FeedPage from './components/FeedPage';
import ProfilePage from './components/ProfilePage';

function App() {
  const [name, setNameInside] = useState({username: (localStorage.getItem('username') !== null ? localStorage.getItem('username') : "") });
  
    const setName = (username) => {
      setNameInside({username});
      if(username === ""){
        localStorage.removeItem('username');
        localStorage.removeItem('token');
        localStorage.removeItem('id');
      }
      else
        localStorage.setItem('username', username);
    }

    const getName = () => {
      return name.username;
    }

  return (
    <div className="App">
      <NavBar setName={setName} getName={getName}/>
      <Routes>
        <Route path='/home' element={<HomeComponent/>} />
        <Route path='/users' element={<UserComponent getName={getName}/>} />
        <Route path='/' element={<LoginComponent setName={setName}/>} />
        <Route path='/register' element={<RegisterComponent/>} />
        <Route path='/betslip' element={<BetslipPage/>} />
        <Route path='/feed' element={<FeedPage/>} />
        <Route path='/profile' element={<ProfilePage/>} />
      </Routes>
    </div>
  );
}

export default App;
