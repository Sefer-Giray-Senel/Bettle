import './App.css';
import { Route, Routes } from 'react-router-dom';
import UserComponent from './components/UserComponent';
import HomeComponent from './components/HomeComponent';
import NavBar from './components/NavBar';
import LoginComponent from './components/LoginComponent';
function App() {
  return (
    <div className="App">
      <NavBar/>
      <Routes>
        <Route path='/home' element={<HomeComponent/>} />
        <Route path='/users' element={<UserComponent/>} />
        <Route path='/' element={<LoginComponent/>} />
      </Routes>
    </div>
  );
}

export default App;
