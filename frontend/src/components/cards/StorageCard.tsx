import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {

    return (
                <div className="card">
                    <div className="description">{props.storage.description}</div>
                    <div className="crts_now">{props.storage.cratesNow} / {props.storage.cratesOrg} crts</div>
                </div>
    );
}

export default StorageCard;