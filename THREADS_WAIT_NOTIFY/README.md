This is an example where a group of producers add messages to a queue from which a group of consumers will remove messages.
1. The queue only accepts a maximum of three messages.
2. If the queue is empty, no consumer will be able to remove any message until a producer enters a message.
3. If the queue is full, no producer will be able to add any messages until a consumer notifies that there is a free space.

