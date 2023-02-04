import React, {useState, useRef, useEffect} from 'react';
import uuid from 'react-uuid'


function App() {
    const employeeIDRef = useRef()
    const employeePasswordRef = useRef()

    function checkCredentials()
    {
        const employeeID = employeeIDRef.current.value
        const employeePassword = employeePasswordRef.current.value

        if (employeeID === '' || employeePassword === '') return

        console.log(employeeID)
        console.log(employeePassword)

        employeeIDRef.current.value = null
        employeePasswordRef.current.value = null
    }

    return (
      <>
          <p>Enter your employee ID and password to login</p>
          <input type="text" ref = {employeeIDRef} placeholder = "Employee ID"/>
          <input type = "password" ref = {employeePasswordRef} placeholder = "password"/>
          <button onClick={checkCredentials}> Submit </button>
      </>
  )
}


export default App;
