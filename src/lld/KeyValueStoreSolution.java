/**

Design and implement an in-memory key value data store.
This data store should be able to support some basic operations such as Get, Set and Delete for string keys and values.

I would like to see test cases as well as implementation code.
You can assume that the input operations are always valid, but the key to operate on may be non-existent.

We won't worry about concurrent access to the database.
You can handle errors however you think is best.
Let's start with the data structure of this key value store.

Implement methods for Get, Set and Delete.


Add support for transactions - Begin, Commit and Rollback.

A transaction is created with the Begin command and creates a context for the other operations to happen.
Until the active transaction is committed using the Commit command, those operations do not persist.
The Rollback command throws away any changes made by those operations in the context of the active transaction.

"Commit()" and "Rollback()" will only happen when inside a transaction, and they both end the transaction.
Note: We won't worry about concurrency for this part of the question.

The following examples demonstrate how this might work:

Example 1
---------

* Set ``key0`` to ``val0``
* Get ``key0``
  * Expect ``val0``
* Begin transaction
* Within transaction: Get ``key0``
  * Expect ``val0``
* Within transaction: Set ``key1`` to ``val1``
* Within transaction: Get ``key1``
  * Expect ``val1``
* Commit transaction
* Outside the transaction: Get ``key1``
  * Expect ``val1``

Example 2
---------

* Begin transaction
* Set ``key2`` to ``val2``
* Get ``key2``
  * Expect ``val2``
* Rollback
* Get ``key2``
  * Expect an error case as ``key2`` is not set

*/

package lld;

import java.lang.*;
import java.util.*;

class KeyValueStoreSolution {

    static class KeyValueStore {
        HashMap<String, String> kvStore, transactionStore;
        HashSet<String> transactionDeletedKeys;
        public boolean inTransaction;

        public KeyValueStore() {
            kvStore = new HashMap<>();
            inTransaction = false;
        }

        // Space Complexity: O(Count of keys)
        // Time Complexity:  O(1)
        public void set(String Key, String Value) {
            if (inTransaction) {
                transactionDeletedKeys.remove(Key);
                transactionStore.put(Key, Value);
            } else {
                kvStore.put(Key, Value);
            }
        }

        // Time Complexity:  O(1)
        public String get(String key) throws Exception {
            if (inTransaction) {
                if (transactionStore.containsKey(key)) {
                    return transactionStore.get(key);
                }

                if (transactionDeletedKeys.contains(key)) {
                    throw new Exception("Input key %s doesnot exist".formatted(key));
                }
            }

            if (kvStore.containsKey(key)) {
                return kvStore.get(key);
            }

            throw new Exception("Input key %s doesnot exist".formatted(key));
        }

        // Time Complexity:  O(1)
        public boolean delete(String key) {
            if (inTransaction) {
                transactionDeletedKeys.add(key);
                return (transactionStore.remove(key) != null);
            }

            return (kvStore.remove(key) != null);
        }

        // Time Complexity:  O(1)
        public void beginTransaction() {
            inTransaction = true;
            transactionStore = new HashMap<>();
            transactionDeletedKeys = new HashSet<>();
        }

        // Time Complexity:  O(count of keys in transactionStore + transactionDeletedKeys)
        public void commitTransaction() {
            if (transactionStore != null) {
                for (Map.Entry<String, String> entry : transactionStore.entrySet()) {
                    kvStore.put(entry.getKey(), entry.getValue());
                }

                for (String deletedKey : transactionDeletedKeys) {
                    kvStore.remove(deletedKey);
                }
            }
            transactionStore = null;
            inTransaction = false;
        }

        // Time Complexity:  O(1)
        public void rollbackTransaction() {
            transactionStore = null;
            inTransaction = false;
        }
    }

    public static void main(String[] args) {
        KeyValueStore kvStore = new KeyValueStore();
/*
        kvStore.beginTransaction();
        kvStore.commitTransaction();
        kvStore.rollbackTransaction();
        try {
            String value = kvStore.get("key0");
            System.out.println(value);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
*/

        kvStore.beginTransaction();
        kvStore.set("key0", "val0");
        kvStore.delete("key0");
        kvStore.set("key0", "val0");
        kvStore.commitTransaction();

        try {
            String value = kvStore.get("key0");
            System.out.println(value);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
