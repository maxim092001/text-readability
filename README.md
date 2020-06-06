# TextReadability
Утилита определяющая читабельность текста по множеству различных параметров:

* [Automated readability index](https://en.wikipedia.org/wiki/Automated_readability_index)
* [Flesch–Kincaid readability tests](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests)
* [SMOG grade](https://en.wikipedia.org/wiki/SMOG)
* [Coleman–Liau index](https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index)

Каждая из метрик позволяет узнать минимальный возраст читателя, который сможет комфортно работать с текстом.

Утилита была написана для личного использования. Помогает анализировать читаемость:

* Документации, которую я писал в [PromoCat](https://api.promocatcompany.com)
* Резюме.
* Какие-то essay/review на английском.


Начало работы
---
Запуск производиться через CLI. Формат: java Main {имя файла}

![Start](https://github.com/maxim092001/TextReadability/blob/master/resources/start.png)

Выбор требуемых параметров и результат
---
Существует 4 режима соответствующих каждой из метрик. Режим **all** считает все метрики.

Режими можно перечислять, например: **ARI FK SMOG** выдаст результаты лишь трех метрик.

![Params](https://github.com/maxim092001/TextReadability/blob/master/resources/params.png)
![Result](https://github.com/maxim092001/TextReadability/blob/master/resources/result.png)
