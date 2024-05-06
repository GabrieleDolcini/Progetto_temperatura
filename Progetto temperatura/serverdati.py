from flask import Flask,request,  make_response
import csv
import json
import datetime as dt
import time


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

@app.route("/add")
def add():
    query_parameters = request.args
    aula = query_parameters.get("aula")
    valore = query_parameters.get("valore")
    
    # Legge l'ultimo ID dal file CSV
    ultimo_id = 0
    with open(csv_file_path, newline='') as csvfile:
        csv_reader = csv.reader(csvfile)
        for row in csv_reader:
            ultimo_id = int(row[0])
    
  
    current_date = dt.date.today()
    current_time = time.strftime("%H:%M", time.localtime())

    with open("dati.csv", "a", newline='') as csvfile:
        if ultimo_id == 0:
            csvfile.write("\n1," + aula + "," + str(current_date) + "," + str(current_time) + "," + valore)
        else:
            csvfile.write("\n" + str(ultimo_id + 1) + "," + aula + "," + str(current_date) + "," + str(current_time) + "," + valore)

    return json.dumps({'success': True}), 200, {'ContentType': 'application/json'}

