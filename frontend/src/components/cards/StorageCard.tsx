import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {
    return (
                <article>
                    <img src="https://picsum.photos/200/300"/>
                    <h3>{props.storage.description}</h3>
                    <p><em>{props.storage.crts_now}</em> / <em>{props.storage.crts_org}</em></p>
                    <a href="#">Details</a>
                </article>
    );
}

export default StorageCard;