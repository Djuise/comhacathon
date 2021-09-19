# Set up
Для запуска тестов через консоль необходимо установить maven ()
Прописать команду: 
`mvn clean install exec:java -Dexec.mainClass=hackaton.RunTests -Dexec.args=${arguments}`
где ${arguments} - список параметров в двойных кавычках через запятую с которыми будет запущен тест
К примеру: 
`"2 tests.RunNegativeLoginTest tests.RunNegativeLoginTest"`
или
`"trheads-count = 2 tests.RunNegativeLoginTest tests.RunNegativeLoginTest"`
где 2 - количество параллельных потоков, а `tests.RunNegativeLoginTest tests.RunNegativeLoginTes` - классы с тестами в которых задан сценарий (формата sc) и классы с шагами. Обязательно указывать package начиная от слова `tests`. Также можно указывать полный путь (пакет) к файлу.
В случае, если количество потоков отсутствует стандартное значение = 1.

Для запуска/дебага из IDE в классе `RunTests.java` можно дописать следующую строку
`ParallelRunner.run(new String[]{"1", "tests.RunNegativeLoginTest"});`
где 1 - количество  потоков, а `tests.RunNegativeLoginTest` - название теста.
Также можно не указывать кол-во потоков.

##
Созданный фреймворк с нуля. Имеет возможность работать параллельно. Для сценарий-файлов и классов с шагами используется собственный синтаксис.
Пример кода для файла сценария:
```
Action: click on Log In button
Check: sign in error is displayed
```

Пример кода для класса шагов:
```
@Action("click on Log In button")
    public void logInBtnClick() { ... }
 @Check("sign in error is displayed")
    public void validationErrorIsDisplayed() {...}
```

## PS
Основная задача для меня была написать именно фреймворк с нуля без использования других билиотек (кроме максимально дефолтных в этом случае). К сожалению, так как времени было крайне мало, много чего реализовать не успели (хоть и много чего сделал). Надеюсь оцените старания, как по мне, вышло очень даже не плохо и даже немного конкурентно способно 😄 .

