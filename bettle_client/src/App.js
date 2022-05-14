import './App.css';
import { Route, Routes } from 'react-router-dom';
import UserComponent from './components/UserComponent';
import HomeComponent from './components/HomeComponent';
import NavBar from './components/NavBar';

function App() {
  return (
    <div className="App">
      <NavBar/>
      <Routes>
        <Route path='/' element={<HomeComponent/>} />
        <Route path='/users' element={<UserComponent/>} />
      </Routes>
    </div>
  );
}

export default App;
