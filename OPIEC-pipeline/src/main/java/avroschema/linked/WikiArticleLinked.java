/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package avroschema.linked;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WikiArticleLinked extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WikiArticleLinked\",\"namespace\":\"avroschema.linked\",\"fields\":[{\"name\":\"title\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"url\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"text\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"links\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"WikiLink\",\"fields\":[{\"name\":\"offset_begin_ind\",\"type\":\"int\"},{\"name\":\"offset_end_ind\",\"type\":\"int\"},{\"name\":\"phrase\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"wiki_link\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String title;
  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String url;
  @Deprecated public java.lang.String text;
  @Deprecated public java.util.List<avroschema.linked.WikiLink> links;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public WikiArticleLinked() {}

  /**
   * All-args constructor.
   */
  public WikiArticleLinked(java.lang.String title, java.lang.String id, java.lang.String url, java.lang.String text, java.util.List<avroschema.linked.WikiLink> links) {
    this.title = title;
    this.id = id;
    this.url = url;
    this.text = text;
    this.links = links;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return title;
    case 1: return id;
    case 2: return url;
    case 3: return text;
    case 4: return links;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: title = (java.lang.String)value$; break;
    case 1: id = (java.lang.String)value$; break;
    case 2: url = (java.lang.String)value$; break;
    case 3: text = (java.lang.String)value$; break;
    case 4: links = (java.util.List<avroschema.linked.WikiLink>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'title' field.
   */
  public java.lang.String getTitle() {
    return title;
  }

  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.String value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'url' field.
   */
  public java.lang.String getUrl() {
    return url;
  }

  /**
   * Sets the value of the 'url' field.
   * @param value the value to set.
   */
  public void setUrl(java.lang.String value) {
    this.url = value;
  }

  /**
   * Gets the value of the 'text' field.
   */
  public java.lang.String getText() {
    return text;
  }

  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.String value) {
    this.text = value;
  }

  /**
   * Gets the value of the 'links' field.
   */
  public java.util.List<avroschema.linked.WikiLink> getLinks() {
    return links;
  }

  /**
   * Sets the value of the 'links' field.
   * @param value the value to set.
   */
  public void setLinks(java.util.List<avroschema.linked.WikiLink> value) {
    this.links = value;
  }

  /** Creates a new WikiArticleLinked RecordBuilder */
  public static avroschema.linked.WikiArticleLinked.Builder newBuilder() {
    return new avroschema.linked.WikiArticleLinked.Builder();
  }
  
  /** Creates a new WikiArticleLinked RecordBuilder by copying an existing Builder */
  public static avroschema.linked.WikiArticleLinked.Builder newBuilder(avroschema.linked.WikiArticleLinked.Builder other) {
    return new avroschema.linked.WikiArticleLinked.Builder(other);
  }
  
  /** Creates a new WikiArticleLinked RecordBuilder by copying an existing WikiArticleLinked instance */
  public static avroschema.linked.WikiArticleLinked.Builder newBuilder(avroschema.linked.WikiArticleLinked other) {
    return new avroschema.linked.WikiArticleLinked.Builder(other);
  }
  
  /**
   * RecordBuilder for WikiArticleLinked instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WikiArticleLinked>
    implements org.apache.avro.data.RecordBuilder<WikiArticleLinked> {

    private java.lang.String title;
    private java.lang.String id;
    private java.lang.String url;
    private java.lang.String text;
    private java.util.List<avroschema.linked.WikiLink> links;

    /** Creates a new Builder */
    private Builder() {
      super(avroschema.linked.WikiArticleLinked.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(avroschema.linked.WikiArticleLinked.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.url)) {
        this.url = data().deepCopy(fields()[2].schema(), other.url);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.text)) {
        this.text = data().deepCopy(fields()[3].schema(), other.text);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.links)) {
        this.links = data().deepCopy(fields()[4].schema(), other.links);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing WikiArticleLinked instance */
    private Builder(avroschema.linked.WikiArticleLinked other) {
            super(avroschema.linked.WikiArticleLinked.SCHEMA$);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.url)) {
        this.url = data().deepCopy(fields()[2].schema(), other.url);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.text)) {
        this.text = data().deepCopy(fields()[3].schema(), other.text);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.links)) {
        this.links = data().deepCopy(fields()[4].schema(), other.links);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'title' field */
    public java.lang.String getTitle() {
      return title;
    }
    
    /** Sets the value of the 'title' field */
    public avroschema.linked.WikiArticleLinked.Builder setTitle(java.lang.String value) {
      validate(fields()[0], value);
      this.title = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'title' field has been set */
    public boolean hasTitle() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'title' field */
    public avroschema.linked.WikiArticleLinked.Builder clearTitle() {
      title = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'id' field */
    public java.lang.String getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public avroschema.linked.WikiArticleLinked.Builder setId(java.lang.String value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'id' field */
    public avroschema.linked.WikiArticleLinked.Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'url' field */
    public java.lang.String getUrl() {
      return url;
    }
    
    /** Sets the value of the 'url' field */
    public avroschema.linked.WikiArticleLinked.Builder setUrl(java.lang.String value) {
      validate(fields()[2], value);
      this.url = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'url' field has been set */
    public boolean hasUrl() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'url' field */
    public avroschema.linked.WikiArticleLinked.Builder clearUrl() {
      url = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'text' field */
    public java.lang.String getText() {
      return text;
    }
    
    /** Sets the value of the 'text' field */
    public avroschema.linked.WikiArticleLinked.Builder setText(java.lang.String value) {
      validate(fields()[3], value);
      this.text = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'text' field has been set */
    public boolean hasText() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'text' field */
    public avroschema.linked.WikiArticleLinked.Builder clearText() {
      text = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'links' field */
    public java.util.List<avroschema.linked.WikiLink> getLinks() {
      return links;
    }
    
    /** Sets the value of the 'links' field */
    public avroschema.linked.WikiArticleLinked.Builder setLinks(java.util.List<avroschema.linked.WikiLink> value) {
      validate(fields()[4], value);
      this.links = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'links' field has been set */
    public boolean hasLinks() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'links' field */
    public avroschema.linked.WikiArticleLinked.Builder clearLinks() {
      links = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public WikiArticleLinked build() {
      try {
        WikiArticleLinked record = new WikiArticleLinked();
        record.title = fieldSetFlags()[0] ? this.title : (java.lang.String) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.String) defaultValue(fields()[1]);
        record.url = fieldSetFlags()[2] ? this.url : (java.lang.String) defaultValue(fields()[2]);
        record.text = fieldSetFlags()[3] ? this.text : (java.lang.String) defaultValue(fields()[3]);
        record.links = fieldSetFlags()[4] ? this.links : (java.util.List<avroschema.linked.WikiLink>) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
