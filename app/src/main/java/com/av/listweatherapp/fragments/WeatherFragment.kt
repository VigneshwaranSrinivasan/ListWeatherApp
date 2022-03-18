package com.av.listweatherapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.av.listweatherapp.R
import com.av.listweatherapp.databinding.FragmentWeatherBinding
import com.av.listweatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private lateinit var binidng : FragmentWeatherBinding
    /*private val viewModel: WeatherViewModel by viewModels()*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_weather, container, false)
        binidng = FragmentWeatherBinding.inflate(inflater,container,false)

        //app is crashing due to null in ViewModel class
        /*viewModel.weatherResponse.observe(viewLifecycleOwner,{ weather->
            binidng.apply {
                lat.text = weather.lat.toString()
                lon.text = weather.lon.toString()
                timezone.text = weather.timezone

                val current = weather.current
                dt.text = current[0].dt.toString()
                sunrise.text = current[1].sunrise.toString()
                sunset.text = current[2].sunset.toString()
                temp.text = current[3].temp.toString()
                feelsLike.text = current[4].feels_like.toString()
                pressure.text = current[5].pressure.toString()
                humidity.text = current[6].humidity.toString()
                dewPoint.text =current[7].dew_point.toString()
                uvi.text = current[8].uvi.toString()
                clouds.text = current[9].clouds.toString()
                visibility.text = current[10].visibility.toString()
                windSpeed.text = current[11].wind_speed.toString()
                windDeg.text = current[12].wind_deg.toString()
                val weathersub = current[14].weather
                id.text = weathersub[0].id.toString()
                main.text = weathersub[1].main
                description.text = weathersub[2].description
                icon.text = weathersub[3].icon

                val minute = weather.minutly
                dtminutly.text = minute[0].dt.toString()
                dtminutly.text = minute[1].precipitation.toString()

                val hour = weather.hourly
                dthourly.text = hour[0].dt.toString()
                sunrisehourly.text = hour[1].sunrise.toString()
                sunsethourly.text = hour[2].sunset.toString()
                temphourly.text = hour[3].temp.toString()
                feelsLikehourly.text = hour[4].feels_like.toString()
                pressurehourly.text = hour[5].pressure.toString()
                humidityhourly.text = hour[6].humidity.toString()
                dewPointhourly.text = hour[7].dew_point.toString()
                uvihourly.text = hour[8].uvi.toString()
                cloudshourly.text = hour[9].clouds.toString()
                visibilityhourly.text = hour[10].visibility.toString()
                windSpeedhourly.text = hour[11].wind_speed.toString()
                windDeghourly.text = hour[12].wind_deg.toString()
                val weatherhour = hour[13].weather
                idhourly.text = weatherhour[0].id.toString()
                mainhourly.text = weatherhour[1].main
                descriptionhourly.text = weatherhour[2].description
                iconhourly.text = weatherhour[3].icon
                pophourly.text = hour[14].pop.toString()


                val daily = weather.daily
                dtdaily.text = daily[0].dt.toString()
                sunrisedaily.text = daily[1].sunrise.toString()
                sunsetdaily.text = daily[2].sunset.toString()
                moonrisedaily.text = daily[3].moonrise.toString()
                moonsetdaily.text = daily[4].moonset.toString()
                moonPhasedaily.text = daily[5].moon_phase.toString()
                val tempdata = daily[6].temp
                dayTemp.text = tempdata[0].day.toString()
                minTemp.text = tempdata[1].min.toString()
                maxTemp.text = tempdata[2].max.toString()
                nightTemp.text = tempdata[3].night.toString()
                eveTemp.text = tempdata[4].eve.toString()
                mornTemp.text = tempdata[5].morn.toString()
                val feeliksdaily = daily[7].feelslike
                nightFeelsLike.text = feeliksdaily[0].night.toString()
                dayFeelsLike.text = feeliksdaily[1].day.toString()
                eveFeelsLike.text = feeliksdaily[2].eve.toString()
                mornFeelsLike.text = feeliksdaily[3].morn.toString()
                pressuredaily.text = daily[8].pressure.toString()
                humiditydaily.text = daily[9].humidity.toString()
                dewPointdaily.text = daily[10].dew_point.toString()
                visibilitydaily.text = daily[11].visibility.toString()
                windSpeeddaily.text = daily[12].wind_speed.toString()
                windDegdaily.text = daily[13].wind_deg.toString()
                windGustdaily.text = daily[14].wind_gust.toString()
                val weatherdaily = daily[15].weather
                iddaily.text = weatherdaily[0].id.toString()
                maindaily.text = weatherdaily[1].main
                descriptiondaily.text = weatherdaily[2].description
                icondaily.text = weatherdaily[3].icon
                cloudsdaily.text =daily[16].clouds.toString()
                popsdaily.text = daily[17].pop.toString()
                uvidaily.text = daily[18].uvi.toString()
            }
        })*/
        return  binidng.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.seconary_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                this.requireView().findNavController()
                    .navigate(R.id.action_weatherFragment_to_loginFragment)
                true
            }
            else -> NavigationUI.onNavDestinationSelected(item,
                requireView().findNavController()) ||super.onOptionsItemSelected(item)
        }
    }


}