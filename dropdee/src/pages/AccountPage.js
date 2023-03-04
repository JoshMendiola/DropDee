import React, {useEffect, useState} from 'react';
import AccountInfo from "../components/AccountInfo";

export default function AccountPage(props)
{
    const [userID] = useState(null);
    const [userInfo, setUserInfo] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8080/user/id/${userID}`)
            .then(res => res.json())
            .then((result) => {setUserInfo(result)})
    },[])


    return (
        <div className="App">
            <AccountInfo
                handleLogin = {props.handleLogin}
                userInfo = {userInfo}
            />
        </div>
    );
}
