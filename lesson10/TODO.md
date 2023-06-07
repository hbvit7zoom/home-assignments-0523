# Lesson 10. Object serialization mechanism

В файле `src/main/resources/input/cd_catalog.xml` располагается информация о музыкальных альбомах.

Необходимо считать данные из этого файла с помощью Jackson XmlMapper.

Составить реестр исполнителей по странам и опубликовать его в виде файлов xml, json и с помощью механизма 
сериализации в директории `src/main/resources/output`.

Пример файла с реестром (результатом работы) в формате xml:

    <ArtistRegistry countryCount="3">
       <Country name="USA">
          <Artist>
             <Name>Example</Name>
             <Albums>
                <Album name="ExampleName" year="Year"/>
                <Album name="ExampleName2" year="Year2"/>
             </Albums>
          </Artist>
          <Artist>...</Artist>
       </Country>
       <Country>...</Country>
       ...
    </ArtistRegistry>

Пример файла с реестром (результатом работы) в формате json:

    {
      "countryCount" : 4,
      "countries" : [ {
        "name" : "EU",
        "artists" : [ {
           "name" : "Savage Rose",
           "albums" : [ {
             "name" : "Black angel",
             "year" : 1995
           } ]
        }...]
      } ]
    }


Так же дополнительно к полученным классам-моделям добавить примеры файлов в src/test/resources и проверить в тестах, 
что они успешно считываются (после чтения файла, полученный объект содержит все значения из файла).

Для зачета достаточно реализовать отдельные классы (чтение, преобразование, запись в конкретном формате) в виде 
отдельных компонентов.

### Критерии приемки

* Покрытие тестами
* Для сериализации/десериализации XML и JSON применяется Jackson библиотека<dependency>
   * com.fasterxml.jackson.core:jackson-databind:2.13.1
   * com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.1
* В решении используется StreamAPI
* Стараемся создавать чистую архитектуру и следовать принципам разработки SOLID, DRY, KISS и т.д.