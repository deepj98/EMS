import axios from 'axios';

const REST_API_SERVER_URL = 'http://localhost:8080/api/employees';

export const putNewEmployeeService = (employee) => axios.post(REST_API_SERVER_URL, employee);

