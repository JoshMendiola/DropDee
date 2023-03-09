import React, {useEffect, useState} from 'react';
import AccountInfo from "../components/AccountInfo";

export default function AccountPage(props)
{
    const [userInfo, setUserInfo] = useState(null);


    useEffect(() => {
        fetch(`http://localhost:8080/user/id/${props.userID}`)
            .then(res => res.json())
            .then(result => setUserInfo(result))
            .catch(error => console.log(error));
    }, [props.userID])

    console.log(userInfo)


    return (
        <div className="App">
            <AccountInfo userInfo = {userInfo}/>
        </div>
    );
}
