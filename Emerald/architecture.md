# Emerald Architecture

## System Overview

Emerald is a Java EE web application following a layered architecture with JSP pages acting as both controllers and views. The system centers on a Data-as-a-Service (DaaS) pattern backed by MongoDB, with supplementary AI/ML modules that can be invoked independently or through the web UI.

```
┌─────────────────────────────────────────────────────────┐
│                     Browser (JSP UI)                    │
│  Login | CRUD | Charts | Sentiment | Speech | ML Pages  │
└───────────────────────────┬─────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────┐
│               Business Delegate Layer                    │
│                    BigDataDelegate                       │
│          (insert/update/delete/query MongoDB)            │
└──────┬──────────────────────────────────────┬───────────┘
       │                                      │
┌──────▼──────────┐              ┌────────────▼───────────┐
│   NoSqlMapper   │              │   RDBMSMapper (MySQL)  │
│   (MongoDB)     │              │   (stub)               │
└──────┬──────────┘              └────────────────────────┘
       │
┌──────▼──────────────────────────────────────────────────┐
│              MongoDB (DAAS database)                     │
│   Collections: User, <entity>Type, entity data          │
└─────────────────────────────────────────────────────────┘
```

## Layer Architecture

### 1. Presentation Layer (WebContent/)

JSP pages serve as the UI. There is no separate MVC framework; JSP scriptlets contain business logic that calls delegates directly.

| JSP | Purpose |
|-----|---------|
| `Login.jsp` / `LoginUser.jsp` | Authentication against MongoDB `User` collection |
| `CRUD.jsp` | Hub page linking to all data operations |
| `CreateEntity.jsp` / `SaveForm.jsp` | Define new entity types with field definitions |
| `EntityList.jsp` / `SaveEntity.jsp` | List and create entity records |
| `SearchEntity.jsp` / `UpdateEntity.jsp` | Search and update records |
| `DataUpload.jsp` / `StoreData.jsp` | CSV file upload and storage |
| `GenerateGraph.jsp` / `ShowChart.jsp` | Chart generation and display |
| `socialmedianalysis.jsp` / `ShowSentiments.jsp` | Social media sentiment analysis |
| `timeAlert.jsp` | Text-to-speech demo |
| `GeoLocation.jsp` | HTML5 geolocation |
| `Paas.jsp` | Platform-as-a-Service landing page |

### 2. Business Delegate Layer

**`BigDataDelegate`** (`platform/businessdelegate/`) is the single entry point for all data operations. It wraps `NoSqlMapper` and provides:

- `insertRecord(database, collection, document)`
- `updateRecord(database, collection, whereQuery, updateQuery)`
- `deleteRecord(database, collection, whereQuery)`
- `getRecord(database, collection, whereQuery)`
- `getRecords(database, collection, whereQuery, fields)`

### 3. Data Access Layer

#### MongoDB (`dataservices/NoSqlMapper`)
- Connects to `localhost:27017`, database `DAAS`
- Uses `BasicDBObject` for queries and updates
- Handles `ObjectId` for record identification
- Key methods: `getQueryRecords()`, `insertRecord()`, `updateRecord()`

#### MySQL (`platform/util/JDBCManager`)
- Connects to `localhost:3306/belfort`
- Used as secondary data store
- Managed via `RDBMSMapper` / `RDBMSReducer` (stubs)

#### MapReduce Abstraction (`dataservices/`)
```
Mapper ──► RDBMSMapper / NoSqlMapper
Partitioner
Reducer ──► RDBMSReducer / NoSqlReducer
```
Provides a MapReduce-style interface for data processing across RDBMS and NoSQL stores.

### 4. Job/Task Execution Framework (`machinelearning/management/`)

```
JobManager
  └── Job
        ├── JobInput  (List<List<String>>)
        ├── JobOutput (List<List<String>>)
        └── ITask[] ──► BigDataTask (CSV parsing demo)
```

- **`IJob`** / **`Job`**: Defines a unit of work containing a list of `ITask` instances.
- **`ITask`** / **`Task`** / **`TaskManager`**: Task abstraction for processing units.
- **`BigDataTask`**: Parses CSV data (hardcoded `airmiles.csv` path).
- **`JobManager`**: Orchestrates job creation and execution.

## AI/ML Modules

Each module is a standalone prototype with `main()` methods and demo data.

### Linear Regression (`datascience/LinearRegression`)
- `getLinearFit(double[] x, double[] y)` - Computes slope and intercept.
- `getLinearFitFromStringValues(List<List<String>>)` - Parses string data for regression.
- Used by `ChartingManager` for trend line generation.

### Deep Neural Network (`neuralnetwork/backpropagation/DeepNeuralNetwork`)
- Multi-layer network with configurable layers and weights.
- Methods: `train()`, `forwardPass()`, `recall()`, `calculateMomentum()`.
- Demo: crime code classification (text-matching approach).

### Hopfield Network (`neuralnetwork/hopfield/HopField`)
- Pattern recognition via energy minimization.
- Methods: `train()`, `recall()`, `deltaEnergy()`.
- Demo: sentiment-based text classification (profanity detection).

### Genetic Algorithm (`geneticalgorithm/processing/`)
- **`Person`**: Individual with 500 genes, fitness calculation, mutation.
- **`Population`**: Collection of individuals with total fitness.

### Simulated Annealing (`simulatedannealing/processing/SimulatedAnnealingManager`)
- Probabilistic optimization via `getProbabilityAcceptance()`.
- Demo: trading lot optimization.

### Recommendation Engine (`recommendationengine/`)
- **`User`**: ID, favourites, ratings.
- **`Product`**: ID, brand, model, attributes.
- **`RecommendationManager`**: Matches products to user preferences.

## Speech Processing

```
┌──────────────────┐     ┌───────────────────────┐
│ SpeechProcessing │     │ SpeechRecognition      │
│ Manager (FreeTTS)│     │ Manager (Sphinx4)      │
│ Text → voice.wav │     │ voice.wav → text        │
└──────────────────┘     └───────────────────────┘
```

- **Synthesis**: FreeTTS with `kevin16` voice, outputs `voice.wav`.
- **Recognition**: Sphinx4 `StreamSpeechRecognizer` with `en-us` acoustic model.

## Social Media & Sentiment Analysis (`mediaresponse/`)

```
MediaResponseManager
  ├── MediaSourceAnalyzer (RSS feeds via ROME)
  │     ├── checkForNetwork (entity extraction)
  │     └── detectPOS (part-of-speech via POSDetector)
  ├── SentimentAnalyzer (keyword matching)
  ├── WebApp (depth-limited web crawler)
  └── HTMLUtil / RTFUtil / URLHelper (parsing utilities)
```

- Crawls RSS feeds and web pages for content.
- Extracts entities (persons, places) and performs POS tagging.
- Matches found text against sentiment dictionaries.

## Simulation Engine (`simulation/`)

```
SimulationManager
  └── EventFlow
        ├── EventLanes
        ├── EventPath (with probability)
        └── Event (ACTION | DISPLAY)
```

- Discrete event simulation with typed events (`ACTION`, `DISPLAY`).
- Events flow through paths with associated probabilities.
- Demo: bus station passenger simulation.

## Charting (`platform/charting/ChartingManager`)

Generates charts as JPEG images using Java AWT/Swing:

| Method | Output |
|--------|--------|
| `drawPieGraph()` | Pie chart |
| `drawBarGraph()` | Bar chart |
| `drawScaledBarGraph()` | Scaled bar chart |
| `drawLineGraph()` | Line graph |
| `drawFitLineGraph()` | Line graph with linear regression fit |
| `generateGraph()` | Parse CSV and generate appropriate chart |
| `generateFitGraph()` | CSV data with regression overlay |

Uses `JPEGCodec` for image encoding.

## Data Flow

### Entity CRUD Flow
```
Browser → JSP (scriptlet) → BigDataDelegate → NoSqlMapper → MongoDB
```

### CSV Upload Flow
```
Browser → DataUpload.jsp → CsvParser → BigDataDelegate → MongoDB
```

### Chart Generation Flow
```
Browser → GenerateGraph.jsp → ChartingManager → AWT Drawing → JPEG → Browser
```

### Sentiment Analysis Flow
```
Browser → socialmedianalysis.jsp → MediaResponseManager
  → MediaSourceAnalyzer → ROME RSS parser
  → SentimentAnalyzer → results to JSP
```

## Database Schema (MongoDB `DAAS`)

| Collection | Purpose | Key Fields |
|------------|---------|------------|
| `User` | Authentication | username, password |
| `<entity>Type` | Entity type definitions | Fieldname, FieldType |
| (dynamic) | Entity instance data | _id, user-defined fields |

## Known Limitations

1. **No MVC framework** - JSP scriptlets contain business logic directly.
2. **Hardcoded paths** - ML modules reference absolute filesystem paths (e.g., `/Users/bhagvan_kommadi/Desktop/BigData/...`).
3. **External dependency** - Some JSPs reference `org.archcorner.chartreuse.esb.*` which is not included in this project.
4. **Stub implementations** - `RDBMSMapper`, `RDBMSReducer`, `NoSqlReducer`, `Node`, `Resource` are empty stubs.
5. **No authentication middleware** - Security is handled per-JSP without a filter or interceptor pattern.
