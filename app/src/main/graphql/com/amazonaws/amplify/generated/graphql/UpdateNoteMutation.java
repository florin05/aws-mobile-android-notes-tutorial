package com.amazonaws.amplify.generated.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.ModelNoteConditionInput;
import type.UpdateNoteInput;

@Generated("Apollo GraphQL")
public final class UpdateNoteMutation implements Mutation<UpdateNoteMutation.Data, UpdateNoteMutation.Data, UpdateNoteMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateNote($input: UpdateNoteInput!, $condition: ModelNoteConditionInput) {\n"
      + "  updateNote(input: $input, condition: $condition) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    title\n"
      + "    content\n"
      + "    blabla\n"
      + "    _version\n"
      + "    _deleted\n"
      + "    _lastChangedAt\n"
      + "    owner\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateNote";
    }
  };

  private final UpdateNoteMutation.Variables variables;

  public UpdateNoteMutation(@Nonnull UpdateNoteInput input,
      @Nullable ModelNoteConditionInput condition) {
    Utils.checkNotNull(input, "input == null");
    variables = new UpdateNoteMutation.Variables(input, condition);
  }

  @Override
  public String operationId() {
    return "e339510a36b6d981402e1fe143da27e1a446426eb173822ce730f1b19e1c79bf";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateNoteMutation.Data wrapData(UpdateNoteMutation.Data data) {
    return data;
  }

  @Override
  public UpdateNoteMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateNoteMutation.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @Nonnull UpdateNoteInput input;

    private @Nullable ModelNoteConditionInput condition;

    Builder() {
    }

    public Builder input(@Nonnull UpdateNoteInput input) {
      this.input = input;
      return this;
    }

    public Builder condition(@Nullable ModelNoteConditionInput condition) {
      this.condition = condition;
      return this;
    }

    public UpdateNoteMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new UpdateNoteMutation(input, condition);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull UpdateNoteInput input;

    private final @Nullable ModelNoteConditionInput condition;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull UpdateNoteInput input, @Nullable ModelNoteConditionInput condition) {
      this.input = input;
      this.condition = condition;
      this.valueMap.put("input", input);
      this.valueMap.put("condition", condition);
    }

    public @Nonnull UpdateNoteInput input() {
      return input;
    }

    public @Nullable ModelNoteConditionInput condition() {
      return condition;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeObject("input", input.marshaller());
          writer.writeObject("condition", condition != null ? condition.marshaller() : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("updateNote", "updateNote", new UnmodifiableMapBuilder<String, Object>(2)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
        .put("condition", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "condition")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateNote updateNote;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateNote updateNote) {
      this.updateNote = updateNote;
    }

    public @Nullable UpdateNote updateNote() {
      return this.updateNote;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateNote != null ? updateNote.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateNote=" + updateNote
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateNote == null) ? (that.updateNote == null) : this.updateNote.equals(that.updateNote));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateNote == null) ? 0 : updateNote.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateNote.Mapper updateNoteFieldMapper = new UpdateNote.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateNote updateNote = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateNote>() {
          @Override
          public UpdateNote read(ResponseReader reader) {
            return updateNoteFieldMapper.map(reader);
          }
        });
        return new Data(updateNote);
      }
    }
  }

  public static class UpdateNote {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("content", "content", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("blabla", "blabla", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("_version", "_version", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("_deleted", "_deleted", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("_lastChangedAt", "_lastChangedAt", null, false, CustomType.AWSTIMESTAMP, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("owner", "owner", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String title;

    final @Nonnull String content;

    final @Nonnull String blabla;

    final int _version;

    final @Nullable Boolean _deleted;

    final long _lastChangedAt;

    final @Nullable String owner;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateNote(@Nonnull String __typename, @Nonnull String id, @Nonnull String title,
        @Nonnull String content, @Nonnull String blabla, int _version, @Nullable Boolean _deleted,
        long _lastChangedAt, @Nullable String owner) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.title = Utils.checkNotNull(title, "title == null");
      this.content = Utils.checkNotNull(content, "content == null");
      this.blabla = Utils.checkNotNull(blabla, "blabla == null");
      this._version = _version;
      this._deleted = _deleted;
      this._lastChangedAt = _lastChangedAt;
      this.owner = owner;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String id() {
      return this.id;
    }

    public @Nonnull String title() {
      return this.title;
    }

    public @Nonnull String content() {
      return this.content;
    }

    public @Nonnull String blabla() {
      return this.blabla;
    }

    public int _version() {
      return this._version;
    }

    public @Nullable Boolean _deleted() {
      return this._deleted;
    }

    public long _lastChangedAt() {
      return this._lastChangedAt;
    }

    public @Nullable String owner() {
      return this.owner;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], title);
          writer.writeString($responseFields[3], content);
          writer.writeString($responseFields[4], blabla);
          writer.writeInt($responseFields[5], _version);
          writer.writeBoolean($responseFields[6], _deleted);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], _lastChangedAt);
          writer.writeString($responseFields[8], owner);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateNote{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "title=" + title + ", "
          + "content=" + content + ", "
          + "blabla=" + blabla + ", "
          + "_version=" + _version + ", "
          + "_deleted=" + _deleted + ", "
          + "_lastChangedAt=" + _lastChangedAt + ", "
          + "owner=" + owner
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateNote) {
        UpdateNote that = (UpdateNote) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.title.equals(that.title)
         && this.content.equals(that.content)
         && this.blabla.equals(that.blabla)
         && this._version == that._version
         && ((this._deleted == null) ? (that._deleted == null) : this._deleted.equals(that._deleted))
         && this._lastChangedAt == that._lastChangedAt
         && ((this.owner == null) ? (that.owner == null) : this.owner.equals(that.owner));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= title.hashCode();
        h *= 1000003;
        h ^= content.hashCode();
        h *= 1000003;
        h ^= blabla.hashCode();
        h *= 1000003;
        h ^= _version;
        h *= 1000003;
        h ^= (_deleted == null) ? 0 : _deleted.hashCode();
        h *= 1000003;
        h ^= _lastChangedAt;
        h *= 1000003;
        h ^= (owner == null) ? 0 : owner.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<UpdateNote> {
      @Override
      public UpdateNote map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String title = reader.readString($responseFields[2]);
        final String content = reader.readString($responseFields[3]);
        final String blabla = reader.readString($responseFields[4]);
        final int _version = reader.readInt($responseFields[5]);
        final Boolean _deleted = reader.readBoolean($responseFields[6]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        final String owner = reader.readString($responseFields[8]);
        return new UpdateNote(__typename, id, title, content, blabla, _version, _deleted, _lastChangedAt, owner);
      }
    }
  }
}
