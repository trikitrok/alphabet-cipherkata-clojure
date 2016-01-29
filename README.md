# alphabet-cipher

[Alphabet Cipher](https://github.com/gigasquid/wonderland-clojure-katas/tree/master/alphabet-cipher) kata from [Carin Meier's](http://gigasquidsoftware.com/) [Living Clojure](http://shop.oreilly.com/product/0636920034292.do) Training Program.

## How to run the tests

The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
