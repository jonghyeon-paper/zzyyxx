# zzyyxx

package hierarchy 
<pre>
─ zz
  └ yy
    └ xx
      ├ api
      │ │ /* system-level */
      │ ├ (example)apps
      │ │ │ /* business(or service)-level */
      │ │ ├ (example)first
      │ │ │ ├ controller
      │ │ │ │ └ {...}
      │ │ │ ├ model
      │ │ │ │ └ {...}
      │ │ │ └ service
      │ │ │   └ {...}
      │ │ └ (example)second
      │ │   ├ controller
      │ │   │ └ {...}
      │ │   ├ model
      │ │   │ └ {...}
      │ │   └ service
      │ │     └ {...}
      │ ├ (example)others
      │ │  └ {...}
      │ ├ path
      │ │ ├ ApiPrefixRequestMapping.class
      │ │ ├ FixedPath.class
      │ │ └ {...}
      │ ├ strategy
      │ │ ├ AppsExceptionHandler.class
      │ │ ├ AppsResponse.class
      │ │ ├ OthersExceptionHandler.class
      │ │ ├ OthersResponse.class
      │ │ ├ OthersResponseWrapper.class
      │ │ ├ SimpleFailureResponseModel.class
      │ │ ├ SimpleResultWrapperModel.class
      │ │ └ {...}
      │ └ {...}
      │
      ├ config
      │ ├ EnumerationConverter.class
      │ ├ EnumerationConverterFactory.class
      │ ├ EnumerationDeserializer.class
      │ ├ EnumerationSerializer.class
      │ ├ ExcutorConfig.class
      │ ├ JacksonConfig.class
      │ ├ ServerConfig.class
      │ ├ SpringWebMvcConfig.class
      │ └ {...}
      │
      ├ core
      │ ├ attribute
      │ │ ├ CodeConversion.class
      │ │ ├ SimpleResponse.class
      │ │ └ {...}
      │ ├ datasource
      │ │ └ {...}
      │ └ {...}
      │
      ├ exception
      │ ├ BusinessException.class
      │ ├ ParameterException.class
      │ ├ ParameterValidation.class
      │ ├ SelfConsumer.class
      │ └ {...}
      │
      ├ misc
      │ ├ MutablePhase.class
      │ ├ MutablePhaseChain.class
      │ └ {...}
      │
      ├ support
      │ ├ JsonSupport.class
      │ ├ 
      │ ├ 
      │ ├ 
      │ ├ 
      │ ├ 
      │ └ {...}
      └ {...}
</pre>

