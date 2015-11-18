KeePass Java API for reading and writing KeePass 1.x (kdb) files. 2.x (kdbx) is planned sometime later.

Since I couldn't find any library that could do that in Java, I had to write one that will suit my needs.
All constant declarations (dirty work) and group/entry reading is based on keepass-java-api everything else is new.

Requires JRE 5.0 or newer.

Should work on Android.(untested)

Depends on SHA256 and AES ciphers by [Bouncy Castle](http://www.bouncycastle.org/latest_releases.html)

```
  <dependency>
     <groupId>org.bouncycastle</groupId>
     <artifactId>bcprov-jdk15</artifactId>
     <version>1.45</version>
  </dependency>
```


Acknowledgements:

  * KeePass: http://keepass.info/
  * KeePass J2ME: http://www.keepassmobile.com/