package com.mikalai.scenary.groovy.closure

def map = ['a': 10, 'b': 50]

Closure square = {key, value -> map[key] = value * value}

map.each square

println map