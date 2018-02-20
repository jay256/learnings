/**
 * @flow
 * @relayHash 774bbb45aa54d5f47b6e0757b8c373d3
 */

/* eslint-disable */

'use strict';

/*::
import type {ConcreteBatch} from 'relay-runtime';
export type NewMessageAddedSubscriptionVariables = {| |};
export type NewMessageAddedSubscriptionResponse = {|
  +messageAdded: ?{|
    +id: string;
    +text: string;
  |};
|};
*/


/*
subscription NewMessageAddedSubscription {
  messageAdded {
    id
    text
  }
}
*/

const batch /*: ConcreteBatch*/ = {
  "fragment": {
    "argumentDefinitions": [],
    "kind": "Fragment",
    "metadata": null,
    "name": "NewMessageAddedSubscription",
    "selections": [
      {
        "kind": "LinkedField",
        "alias": null,
        "args": null,
        "concreteType": "Message",
        "name": "messageAdded",
        "plural": false,
        "selections": [
          {
            "kind": "ScalarField",
            "alias": null,
            "args": null,
            "name": "id",
            "storageKey": null
          },
          {
            "kind": "ScalarField",
            "alias": null,
            "args": null,
            "name": "text",
            "storageKey": null
          }
        ],
        "storageKey": null
      }
    ],
    "type": "Subscription"
  },
  "id": null,
  "kind": "Batch",
  "metadata": {},
  "name": "NewMessageAddedSubscription",
  "query": {
    "argumentDefinitions": [],
    "kind": "Root",
    "name": "NewMessageAddedSubscription",
    "operation": "subscription",
    "selections": [
      {
        "kind": "LinkedField",
        "alias": null,
        "args": null,
        "concreteType": "Message",
        "name": "messageAdded",
        "plural": false,
        "selections": [
          {
            "kind": "ScalarField",
            "alias": null,
            "args": null,
            "name": "id",
            "storageKey": null
          },
          {
            "kind": "ScalarField",
            "alias": null,
            "args": null,
            "name": "text",
            "storageKey": null
          }
        ],
        "storageKey": null
      }
    ]
  },
  "text": "subscription NewMessageAddedSubscription {\n  messageAdded {\n    id\n    text\n  }\n}\n"
};

module.exports = batch;
