import time
from SPARQLWrapper import SPARQLWrapper, JSON

# URL SPARQL-эндпоинта для Wikidata
sparql = SPARQLWrapper("https://query.wikidata.org/sparql")

# SPARQL-запрос для получения триплетов с метками и описаниями
sparql.setQuery("""
    SELECT ?subject ?subjectLabel ?predicate ?predicateLabel ?object ?objectLabel WHERE {
      ?subject ?predicate ?object.
      ?subject rdfs:label ?subjectLabel.
      ?predicate rdfs:label ?predicateLabel.
      ?object rdfs:label ?objectLabel.
      
      FILTER(LANG(?subjectLabel) = "en")
      FILTER(LANG(?predicateLabel) = "en")
      FILTER(LANG(?objectLabel) = "en")
    } LIMIT 10
""")

sparql.setReturnFormat(JSON)

# Функция для логирования времени и статуса запроса
def log_verbose(status, start_time=None):
    if status == 'start':
        print("Запрос начат...")
        return time.time()  # Возвращаем время начала
    elif status == 'end':
        if start_time:
            print(f"Запрос завершен. Время выполнения: {time.time() - start_time:.2f} секунд.")
        else:
            print("Запрос завершен.")
    elif status == 'error':
        print("Произошла ошибка при выполнении запроса.")

# Логируем начало запроса
start_time = log_verbose('start')

# Выполнение запроса с обработкой ошибок
try:
    print("Выполняем SPARQL запрос...")
    results = sparql.query().convert()
    log_verbose('end', start_time)
    
    # Проверка на наличие данных
    if "results" in results:
        print(f"Найдено {len(results['results']['bindings'])} результатов.")
        
        # Вывод результатов
        for result in results["results"]["bindings"]:
            subject = result["subjectLabel"]["value"]
            predicate = result["predicateLabel"]["value"]
            object = result["objectLabel"]["value"]
            print(f"Subject: {subject}, Predicate: {predicate}, Object: {object}")
    else:
        print("Результаты не найдены.")

except Exception as e:
    log_verbose('error')
    print(f"Ошибка: {str(e)}")
