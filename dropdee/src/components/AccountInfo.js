import React, {useState} from 'react';

function AccountInfo(props)
{
    const [userinfo, setUserinfo] = useState(props.userInfo)
    return (
        <div>
            <h1>{userinfo}</h1>
        </div>
    );
}

export default AccountInfo;