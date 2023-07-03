import React from 'react';
import {StorageModel} from "../models/StorageModel";

type Props = {
    storage: StorageModel
}
function UserStorageCard(props: Props) {
    return (
        <div>
            <div className="description">{props.storage.description}</div>
            <div className="crts_now">{props.storage.cratesNow} / {props.storage.cratesOrg} crts</div>
        </div>
    );
}

export default UserStorageCard;