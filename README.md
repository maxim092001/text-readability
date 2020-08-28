# TextReadability
A utility that determines the readability of the text by many different parameters:

* [Automated readability index](https://en.wikipedia.org/wiki/Automated_readability_index)
* [Flesch–Kincaid readability tests](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests)
* [SMOG grade](https://en.wikipedia.org/wiki/SMOG)
* [Coleman–Liau index](https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index)

Each of the metrics allows you to find out the minimum age of a reader who can comfortably work with text.

The utility was written for personal use. Helps analyze readability:

* The documentation I wrote in[PromoCat](https://promocatcompany.com)
* CV.
* Some essay/review in English.


Launching
---
Launch via CLI. Format: java Main {file name}

![Start](https://github.com/maxim092001/TextReadability/blob/master/resources/start.png)

Select required parameters
---
There are 4 modes corresponding to each of the metrics. ** all ** mode counts all metrics.

The modes can be listed, for example: ** ARI FK SMOG ** will return the results of only three metrics.

![Params](https://github.com/maxim092001/TextReadability/blob/master/resources/params.png)
![Result](https://github.com/maxim092001/TextReadability/blob/master/resources/result.png)

This project was created at [JetBrains Academy](https://www.jetbrains.com/ru-ru/academy/),
[Hyperskill](https://hyperskill.org/) platform.
