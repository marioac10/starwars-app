package com.example.starshipsacapp.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

const val DataStore_NAME = "STARSHIP"

val Context.datastore : DataStore< Preferences> by  preferencesDataStore(name = DataStore_NAME)