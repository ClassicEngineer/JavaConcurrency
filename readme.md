Definitions

## volatile

Volatile a field may be declared volatile, in which case the Java Memory Model ensures that all threads see a consistent value for the variable

volatile adds atomicity to long, double

There are plain read and volatile read.

assignment through '='  volatile is atomic

volatile arrays are not exist

volatile write HB volatile read

MESI

NUMA

cache coherence

JMM - Java Memory Model

## Happens Before

happens before - predicate that applies for two operations

A happens before B if all WRITE operations executed before A(inclusive) are visible in all READ operations after B 

Examples:

- (program order)
- constructor end X() HB X.finalize()
- thread start() HB any action in thread
- last action in thread HB thread.join()
- total order between syncs on object
- finish of sync HB start of next sync
