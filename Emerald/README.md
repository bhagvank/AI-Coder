# Emerald

**Prevention by Prediction** - An AI and Big Data analytics platform built on Java EE.

Emerald is a web-based platform that combines machine learning, natural language processing, speech processing, sentiment analysis, and data-as-a-service capabilities into a single application. It provides a browser-based UI for uploading CSV data, performing CRUD operations on MongoDB, generating charts with regression analysis, and running AI/ML algorithms.

## Tech Stack

- **Language**: Java SE 1.7
- **Runtime**: Apache Tomcat 8.0 (Servlet 3.1)
- **Build**: Eclipse Dynamic Web Project
- **Databases**: MongoDB (primary), MySQL (secondary)
- **Frontend**: Bootstrap 3, jQuery 1.10.2, JSP

## Libraries

| Library | Version | Purpose |
|---------|---------|---------|
| MongoDB Java Driver | 3.3.0 | Database access |
| MySQL Connector/J | 5.0.8 | RDBMS access |
| FreeTTS | - | Speech synthesis |
| Sphinx4 | 1.0.0 | Speech recognition |
| ROME | 1.0 | RSS feed parsing |
| JDOM | 1.1.3 | XML processing |

## Project Structure

```
Emerald/
  src/com/architectcorner/ai/
    machinelearning/         # ML framework
      datascience/           #   Linear regression
      dataservices/          #   MongoDB/RDBMS mappers and reducers
      management/            #   Job/task execution framework
      processing/            #   Node and resource management
    neuralnetwork/
      backpropagation/       #   Deep neural network (backpropagation)
      hopfield/              #   Hopfield network (pattern recall)
    nlp/processing/          # Part-of-speech detection
    simulatedannealing/      # Simulated annealing optimizer
    geneticalgorithm/        # Genetic algorithm (population/fitness)
    speech/
      processing/            #   Text-to-speech (FreeTTS)
      recognition/           #   Speech-to-text (Sphinx4)
    mediaresponse/           # Social media and sentiment analysis
      manager/               #   RSS/web crawling and analysis
      sentiment/             #   Sentiment analyzer
      util/                  #   HTML/RTF/URL utilities, web crawler
    network/analysis/        # Entity network graph
    recommendationengine/    # Product recommendation engine
    simulation/              # Event-based simulation engine
    platform/
      businessdelegate/      # JSP-facing data access layer
      charting/              # AWT/Swing chart generation
      esb/                   # CSV parsing and data validation
      util/                  # JDBC, XML utilities
  WebContent/
    *.jsp                    # 36 JSP pages (UI)
    css/, js/, fonts/        # Frontend assets (Bootstrap 3)
    sass/                    # SCSS sources
    WEB-INF/lib/             # JAR dependencies
```

## Getting Started

### Prerequisites

- Java JDK 1.7+
- Apache Tomcat 8.0
- MongoDB running on `localhost:27017`
- MySQL running on `localhost:3306` (database: `belfort`, user: `root`/`root`)

### Setup

1. Import the project into Eclipse as an existing Dynamic Web Project.
2. Ensure MongoDB is running and accessible on port 27017.
3. Deploy to Tomcat 8.0.
4. Navigate to `http://localhost:8080/Emerald/`.

### Database

The primary database is MongoDB (`DAAS`). Collections include:
- `User` - User authentication records
- `<entity>Type` - Dynamic entity type definitions (field names and types)
- Entity data collections created through the CRUD UI

## Features

- **Data Upload**: Upload CSV files into MongoDB via the web interface.
- **CRUD Operations**: Create, read, update, and delete entity records through the browser.
- **Charting**: Generate pie charts, bar charts, line graphs, and regression fit lines from data.
- **Sentiment Analysis**: Analyze social media/RSS feeds for sentiment.
- **Speech Processing**: Text-to-speech and speech-to-text demos.
- **Machine Learning**: Linear regression, neural networks, genetic algorithms, simulated annealing.
- **Recommendation Engine**: Product recommendation based on user preferences.
- **Geolocation**: HTML5 geolocation demo page.

## Notes

- Several ML classes contain `main()` methods with hardcoded demo data and absolute file paths intended for local development.
- The project references external classes from a sibling "Chartreuse" project (e.g., `org.archcorner.chartreuse.esb`) in some JSP pages.
