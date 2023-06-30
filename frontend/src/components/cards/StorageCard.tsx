import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {

    const { storage } = props;

    return (
                <div className="card">
                    <div className="description">{props.storage.description}</div>
                    <div className="crts_now">{props.storage.cratesNow} / {props.storage.cratesOrg} crts</div>
                    <button className="details-button">Details</button>
                </div>
    );
}

export default StorageCard;