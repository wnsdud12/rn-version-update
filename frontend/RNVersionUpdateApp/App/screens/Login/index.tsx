import {View, Text, TextInput} from 'react-native';
import React, {useState} from 'react';

export default function Login() {
  const [input, setInput] = useState({
    id: '',
    password: '',
  });

  return (
    <View>
      <Text>Login</Text>
      <TextInput value={input.id} onChangeText={(text) => setInput({ ...input, id: text})} />
      <TextInput value={input.password} onChangeText={(text) => setInput({ ...input, password: text})} />
    </View>
  );
}
