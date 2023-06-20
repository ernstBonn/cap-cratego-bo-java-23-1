import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {

    const { storage } = props;

    const imageDataUrl = `data:image/jpeg;base64,${storage.image}`;

    return (
                <div className="card">
                    <div className="image">
                        <img src={imageDataUrl} alt="Storage Image" />
                    </div>
                    <div className="description">{props.storage.description}</div>
                    <div className="crts_now">{props.storage.crts_now} / {props.storage.crts_org} crts</div>
                    <button className="details-button">Details</button>
                </div>
    );
}

export default StorageCard;