import React from 'react';

type Props = {
    id: string
}
function UserStorageCard(props: Props) {
    return (
        <div>
            {/*<div className="description">{props.storage.description}</div>*/}
            {/*<div className="crts_now">{props.storage.cratesNow} / {props.storage.cratesOrg} crts</div>*/}
        </div>
    );
}

export default UserStorageCard;