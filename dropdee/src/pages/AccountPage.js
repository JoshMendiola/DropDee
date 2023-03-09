import React, {useEffect, useState} from 'react';
import AccountInfo from "../components/AccountInfo";

export default function AccountPage(props)
{
    const [userID, setUserID] = useState(props.userID);
    const [userInfo, setUserInfo] = useState(null);

    console.log(userID)

    useEffect(() => {
        fetch(`http://localhost:8080/user/id/${userID}`)
            .then(res => res.json())
            .then((result) => {setUserInfo(result)})
    }, [])

    console.log(userInfo)


    return (
        <div className="App">
            <AccountInfo userInfo = {userInfo}/>
        </div>
    );
}
