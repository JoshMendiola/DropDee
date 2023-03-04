import React from 'react';
import UserRegistration from "../components/UserRegistration";


function UserRegistrationPage(props) {

    return (
        <div className="App">
            <UserRegistration handleLogin={props.handleLogin}/>
        </div>
    )
}

export default UserRegistrationPage;