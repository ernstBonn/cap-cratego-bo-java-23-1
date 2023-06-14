import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {
    return (
        <div>
            <h1>{props.storage.description}</h1>
            <p>{props.storage.crts_now} / {props.storage.crts_org}</p>
        </div>
    );
}

export default StorageCard;