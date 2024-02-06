from flask import Flask,  make_response
import csv
import json

app = Flask(__name__)

csv_file_path= 'dati.csv'



def leggi_da_file():
    dati = []
    with open(csv_file_path,newline='') as csvfile:
        csv_reader = csv.reader(csvfile)
        for row in csv_reader:
            m = {'id': row[0], 'aula': row[1],'giorno': row[2],'ora': row[3],'valore': row[4]}
            dati.append(m)
    return dati

@app.route("/")
def index():

    data = leggi_da_file()

    response = app.response_class(
        response = json.dumps(data),
        mimetype ='application/json'
    )
    response.headers.add("Access-Control-Allow-Origin", "*")
    return response
