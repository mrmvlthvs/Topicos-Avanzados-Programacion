import json
import os

class Person(object):
    def __init__(self, first_name=None, last_name=None):
        self.first_name = first_name
        self.last_name = last_name

    # Returns Person name, ex: John Doe
    def name(self):
        return f"{self.first_name} {self.last_name}"

    @classmethod
    # Returns all people inside db.txt as a list of Person objects
    def getAll(cls):
        # Obtiene la ruta absoluta de la carpeta donde está model.py
        current_dir = os.path.dirname(os.path.abspath(__file__))
        db_path = os.path.join(current_dir, 'db.txt')
        
        result = []
        # Usa 'with' para asegurar que el archivo se cierre automáticamente
        with open(db_path, 'r', encoding='utf-8') as database:
            json_list = json.loads(database.read())
            for item in json_list:
                person = Person(item['first_name'], item['last_name'])
                result.append(person)
        return result