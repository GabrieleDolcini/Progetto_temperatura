from flask import Flask,  make_response

app = Flask(__name__)

dati = """
    [
        {"id":1, "aula": "MM2", "giorno": "2024-01-23", "ora":"10:23", "valore": "20.5" },
        {"id":2, "aula": "MM2", "giorno": "2024-01-23", "ora":"10:23", "valore": "20.5" },
        {"id":3, "aula": "MM2", "giorno": "2024-01-23", "ora":"10:23", "valore": "20.5" },
        {"id":4, "aula": "MM2", "giorno": "2024-01-23", "ora":"10:23", "valore": "20.5" },
        {"id":5, "aula": "MM2", "giorno": "2024-01-23", "ora":"10:23", "valore": "20.5" }
    ]
"""

@app.route("/")
def index():
    response = app.response_class(
        response=dati,
        mimetype='application/json'
    )
    response.headers.add("Access-Control-Allow-Origin", "*")
    return response