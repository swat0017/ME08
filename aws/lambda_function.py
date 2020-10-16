#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Aug 29 00:47:42 2020
@author: pravinkumarthangavelu
"""
import json
import pymysql

endpoint = 'database1-ie.ch46tnys7uhd.us-east-1.rds.amazonaws.com'
username = 'admin'
password = 'darsinik'
database_name = 'mydatabase'

connection = pymysql.connect(endpoint, user=username, passwd = password, db=database_name)



def lambda_handler(event,context):
  cursor = connection.cursor()
  cursor.execute('SELECT * from ANIMAL')
  
  rows = cursor.fetchall()
  responseObject={}
  responseObject['statusCode']=200
  responseObject['headers']={}
  responseObject['headers']['Content-Type']='application/json'
 
  rowsJson=[]
  for row in rows:
      rowJson={}
      rowJson['animalCategory']=row[0]
      print("{0}".format(row[0]))
      rowsJson.append(rowJson)
      
      
      
  responseObject['body']=rowsJson
  return responseObject
  
#lambda_handler()
