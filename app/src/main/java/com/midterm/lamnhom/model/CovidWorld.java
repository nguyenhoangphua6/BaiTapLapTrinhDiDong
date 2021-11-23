package com.midterm.lamnhom.model;

public class CovidWorld {
    private long updated;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int todayRecovered;
    private int active;
    private int critical;
    private int casesPerOneMillion;
    private float deathsPerOneMillion;
    private long tests;
    private float testsPerOneMillion;
    private long population;
    private int oneCasePerPeople;
    private int oneDeathPerPeople;
    private int oneTestPerPeople;
    private float activePerOneMillion;
    private float recoveredPerOneMillion;
    private float criticalPerOneMillion;
    private int affectedCountries;

    public CovidWorld(long updated, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int todayRecovered, int active, int critical, int casesPerOneMillion, float deathsPerOneMillion, long tests, float testsPerOneMillion, long population, int oneCasePerPeople, int oneDeathPerPeople, int oneTestPerPeople, float activePerOneMillion, float recoveredPerOneMillion, float criticalPerOneMillion, int affectedCountries) {
        this.updated = updated;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.affectedCountries = affectedCountries;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public float getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(float deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
        this.tests = tests;
    }

    public float getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(float testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(int oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public int getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(int oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public int getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(int oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public float getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(float activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public float getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(float recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public float getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(float criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(int affectedCountries) {
        this.affectedCountries = affectedCountries;
    }
}
