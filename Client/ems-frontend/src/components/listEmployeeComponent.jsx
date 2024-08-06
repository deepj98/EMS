import axios from 'axios'
import React, {useEffect, useState} from 'react'
import { getAllEmployeeList } from '../services/getAllEmployeeService'
import { useNavigate } from 'react-router-dom'



const ListEmployeeComponent = () => {

    const [Employees, setEmployees] = useState([])
    const navigator = useNavigate();


    useEffect(() => {
    getAllEmployeeList().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error)
        });
        
    }, [])

    function addNewEmployee() {
        navigator('/add-employee');

    }

  return (
    <div className='container'>
        <h2>Employee Management Tool</h2>
        <button className='btn-btn-primary mg-2' onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th> Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                {
                    Employees.map(employee => 
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                    </tr>)
                }
            </tbody>
        </table>


    </div>
  )
}

export default ListEmployeeComponent