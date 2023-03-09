import React, {useState} from "react";
import UserLogin from "../components/UserLogin";

export default function UserLoginPage(props) {


    const handleLogin = (id) => {
        props.handleLogin(id);
    };

    return (
        <div className="App">
            <UserLogin handleLogin = {handleLogin}/>
        </div>
    )
}
