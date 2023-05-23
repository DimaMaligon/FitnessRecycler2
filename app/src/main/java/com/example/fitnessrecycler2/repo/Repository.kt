package com.example.fitnessrecycler2.repo

import com.example.fitnessrecycler2.api.ApiFitness

class Repository constructor(val apiFitness: ApiFitness) {
    fun getFitnessData() = apiFitness.getJsonFitness()
}