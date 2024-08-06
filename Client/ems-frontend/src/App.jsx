import './App.css'
import Helloworld from './helloworld'
import ListEmployeeComponent from './components/listEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import AddEmployeeComponent from './components/AddEmployeeComponent'

function App() {
  

  return (
    <>
    <BrowserRouter>
    <HeaderComponent />
    <Routes>
      <Route path='/' element = {<ListEmployeeComponent />}> </Route>
      <Route path='/employees' element = {<ListEmployeeComponent/>}> </Route>
      <Route path='/add-employee' element = {<AddEmployeeComponent />}> </Route>
    

    </Routes>

    </BrowserRouter>

    
    </>
  )
}

export default App
