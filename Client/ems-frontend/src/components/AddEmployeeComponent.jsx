import React, { useState } from 'react'
import { putNewEmployeeService } from '../services/putNewEmployeeService';
import { useNavigate } from 'react-router-dom';


const AddEmployeeComponent = () => {

    const[firstName, setfirstName] = useState('');
    const[lastName, setLastName] = useState('');
    const[email, setEmail] = useState('');

    const [error, setError]  = useState({
        firstName : '',
        lastName : '',
        email: '',
    })

    const navigator = useNavigate();

    function saveEmployee(e){

        if(validateForm()){
        e.preventDefault();
        const newEmployee = {firstName, lastName, email}
        console.log(newEmployee)

        putNewEmployeeService(newEmployee)
        .then((response ) => {
            console.log(response.data);
            navigator('/employees');

        }).catch((error) => {
            console.log(error)
        })
            
        }

        
    }

    function validateForm(){
        let valid = true;
        const errorCopy = {... error}
        
        if(firstName.trim()){
            errorCopy.firstName = '';
        }else{
            errorCopy.firstName = 'First name is required';
            valid = false;
        }

        if(lastName.trim()){
            errorCopy.lastName = '';
        }else{
            errorCopy.lastName = 'Last name is required';
            valid = false;
        }
        if(email.trim()){
            errorCopy.email = '';
        }else{
            errorCopy.email = 'Email name is required';
            valid = false;
        }

        setError(errorCopy);
        return valid;
        
    }
    
  return (
    <div className='container'>
        <div className='row'>
            <div className='card'>
                <h2 className='text-center'>Add Employees</h2>

                <div className='card-body'>
                    <form>
                        {/* firstName */}
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name: </label>
                            <input type='text' name='firstName' value={firstName} 
                            className = {`form-control ${error.firstName ? 'is-invalid':''  }`}
                            onChange={(e) => setfirstName(e.target.value)}>    
                            </input>

                            {error.firstName && <div className='invalid-feedback'> { error.firstName}</div>}
                        </div>

                        {/* lastname */}
                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name: </label>
                            <input type='text' name='lastName' value={lastName} 
                            className = {`form-control ${error.lastName ? 'is-invalid':''  }`}
                            onChange={(e) => setLastName(e.target.value)}></input>

                            {error.lastName && <div className='invalid-feedback'> {error.lastName}</div>}

                        </div>

                        {/* email */}

                        <div className='form-group mb-2'>
                            <label className='form-label'> Email</label>
                            <input type='email' name='email' value={email}
                            className= {`form-control ${error.email ? 'is-invalid': ''}`} 
                            onChange={(e) => setEmail(e.target.value)}></input>
                        </div>

                        <button className='btn btn-success' onClick={saveEmployee}>Submit</button> 

                    </form>
                </div>


            </div>
        </div>
    </div>
  )
}

export default AddEmployeeComponent