import React from "react";
import UserLogin from "../components/UserLogin";

export default function UserLoginPage(props) {

    return (
        <div className="App">
            <UserLogin changeAppBar = {props.changeAppBar}/>
        </div>
    )
}
